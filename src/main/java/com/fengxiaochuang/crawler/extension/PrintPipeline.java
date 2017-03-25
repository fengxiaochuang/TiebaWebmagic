/**
* @author 冯晓闯 E-mail:lanxinxichen@126.com
* @version 创建时间：2016年1月29日 下午1:20:09
* 类说明:
*/
package com.fengxiaochuang.crawler.extension;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.Map;
import java.util.Map.Entry;

public class PrintPipeline implements Pipeline {

	@Override
	public void process(ResultItems resultItems, Task task) {
		Map<String, Object> map = resultItems.getAll();
		for (Entry<String, Object> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "=>" + entry.getValue());
		}
	}

}
