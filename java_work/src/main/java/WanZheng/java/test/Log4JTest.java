package WanZheng.java.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 日志级别
 * 共有 8 个级别，按照从低到高为:All < Trace < Debug < Info < Warn < Error < Fatal < OFF.
 * All:最低等级的，用于打开所有日志记录. Trace:是追踪，就是程序推进以下，你就可以写个 trace 输出，所以 trace 应该 会特别多，不过没关系，我们可以设置最低日志级别不让他输出. Debug:指出细粒度信息事件对调试应用程序是非常有帮助的. Info:消息在粗粒度级别上突出强调应用程序的运行过程.
 * Warn:输出警告及 warn 以下级别的日志.
 * Error:输出错误信息日志. Fatal:输出每个严重的错误事件将会导致应用程序的退出的日志. OFF:最高等级的，用于关闭所有日志记录.
 */

public class Log4JTest {
	
	private static final Logger logger = LoggerFactory.getLogger(Log4JTest.class);
	
	public static void main(String[] args) {
//		while(true) {
//			try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		logger.debug("debug");
//		logger.info("info");
//		logger.warn("warn");
//		logger.error("error");
//		}
		
		logger.debug("debug");
		logger.info("info");
		logger.warn("warn");
		logger.error("error");
	}

}
