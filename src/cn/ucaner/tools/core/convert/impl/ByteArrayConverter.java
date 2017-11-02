package cn.ucaner.tools.core.convert.impl;

import cn.ucaner.tools.core.convert.AbstractConverter;
import cn.ucaner.tools.core.convert.ConverterRegistry;
import cn.ucaner.tools.core.util.ArrayUtil;

/**
 * byte 类型数组转换器
 * @author Looly
 *
 */
public class ByteArrayConverter extends AbstractConverter<byte[]>{
	
	@Override
	protected byte[] convertInternal(Object value) {
		final Byte[] result = ConverterRegistry.getInstance().convert(Byte[].class, value);
		return ArrayUtil.unWrap(result);
	}

}
