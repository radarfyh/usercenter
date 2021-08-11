package work.metanet.exception;

public class MetanetExceptionAssert {
	/**
	 * 断言，b为真则抛出异常
	 * @param b 条件
	 * @param format 异常中返回消息的格式化串
	 * @param messages 返回消息
	 */
	public static void assertTrue(boolean b, String format, Object... messages) {
		if (b) {
			fail(format, messages);
		}
	}
	/**
	 * 断言，b为假则抛出异常
	 * @param b 条件
	 * @param format 异常中返回消息的格式化串
	 * @param messages 返回消息
	 */
	public static void assertFalse(boolean b, String format, Object... messages) {
		if (!b) {
			fail(format, messages);
		}
	}
	/**
	 * 断言，b为真则抛出异常
	 * @param b 条件
	 * @param code 响应码
	 * @param format 异常中返回消息的格式化串
	 * @param messages 返回消息
	 */
	public static void assertTrue(boolean b, Integer code, String format, Object... messages) {
		if (b) {
			fail(code, format, messages);
		}
	}

	/**
	 * 断言，b为假则抛出异常
	 * @param b 条件
	 * @param code 响应码
	 * @param format 异常中返回消息的格式化串
	 * @param messages 返回消息
	 */
	public static void assertFalse(boolean b, Integer code, String format, Object... messages) {
		if (!b) {
			fail(code, format, messages);
		}
	}
	
	private static void fail(String format, Object... messages) {
		// 抛出异常，响应码默认为500, SERVER_FAILURE
		throw new MetanetException(String.format(format, messages));
	}
	
	private static void fail(Integer code, String format, Object... messages) {
		throw new MetanetException(code, String.format(format, messages));
	}
}
