package com.taotao.rest.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.tools.corba.se.idl.PragmaEntry;
import com.taotao.jedis.JedisClientPool;
import com.taotao.rest.bo.ItemGroupItem;
import com.taotao.rest.bo.ItemParams;
import com.taotao.rest.pojo.TbItemParamItem;
import com.taotao.rest.service.TbItemParamItemService;
import com.taotao.util.JsonUtils;

import tk.mybatis.mapper.entity.Example;

@Service(value="tbItemParamService")
public class TbItemParamItemServiceImpl extends BaseService<TbItemParamItem> implements TbItemParamItemService {
	@Autowired
	private JedisClientPool pool;

	@Override
	public String selectByItemId(Long itemId) {
		// redis取
		try {
			String paramItem = pool.get("item:" + itemId + ":param");
			if(null!=paramItem){
				
				TbItemParamItem param = JsonUtils.jsonToPojo(paramItem, TbItemParamItem.class);
				String paramData = param.getParamData();
				return getPramHtml(paramData);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 从数据库获取
		Example example = new Example(TbItemParamItem.class);
		example.createCriteria().andEqualTo("itemId", itemId);
		List<TbItemParamItem> params = myMapper.selectByExample(example);
		if (null != params && params.size()!=0) {
			TbItemParamItem param = params.get(0);
			// 存到数据库
			try {
				pool.set("item:" + itemId + ":param", JsonUtils.objectToJson(param));
				pool.expire("item:"+itemId+":param", 60*60*60*24);//缓存一天
			} catch (Exception e) {
				e.printStackTrace();
			}
			return getPramHtml(param.getParamData());
		}
		return null;
	}

	private String getPramHtml(String paramData) {
		List<ItemGroupItem> param = JsonUtils.jsonToList(paramData, ItemGroupItem.class);
		StringBuilder sb = new StringBuilder();
		sb.append("<table cellsapce ='0' border='0' width='100%' class='Ptable'> ");
		for (ItemGroupItem group: param) {
			
			sb.append("<tr>");
			sb.append("<tb colspan='2'>" +group.getGroup()+ "</tb>");
			sb.append("</tr>");
			
			ItemParams[] params = group.getParams();
			for (ItemParams itemParams:params) {
				sb.append("<tr>");
				sb.append("<td>" + itemParams.getK()+ "</td>");
				sb.append("<td>" + itemParams.getV()+ "</td>");
				sb.append("</tr>");
			}
		}
		
		sb.append("</table>");
		return sb.toString();
	}
/*	使用List<Map>来解析
 * private String getPramHtml(String paramData) {
		List<Map> param = JsonUtils.jsonToList(paramData, Map.class);
		StringBuilder sb = new StringBuilder();
		sb.append("<table cellsapce ='0' border='0' width='100%' class='Ptable'> ");
		for (Map group: param) {
			
			sb.append("<tr>");
			sb.append("<tb colspan='2'>" +group.get("group") + "</tb>");
			sb.append("</tr>");
			
			List<Map> params = (List<Map>) group.get("params");
			for (Map map:params) {
				sb.append("<tr>");
				sb.append("<td>" + map.get("k") + "</td>");
				sb.append("<td>" + map.get("v") + "</td>");
				sb.append("</tr>");
			}
		}
		
		sb.append("</table>");
		return sb.toString();
	}
*/
}
