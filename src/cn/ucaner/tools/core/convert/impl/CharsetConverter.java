package cn.ucaner.tools.core.convert.impl;

import java.nio.charset.Charset;

import cn.ucaner.tools.core.convert.AbstractConverter;
import cn.ucaner.tools.core.util.CharsetUtil;

/**
 * 编码对象转换器
 * @author Looly
 *
 */
public class CharsetConverter extends AbstractConverter<Charset>{

	@Override
	protected Charset convertInternal(Object value) {
		return CharsetUtil.charset(convertToStr(value));
	}

}
