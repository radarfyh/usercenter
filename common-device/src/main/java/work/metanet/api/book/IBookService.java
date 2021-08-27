package work.metanet.api.book;

import java.util.List;

import work.metanet.api.book.protocol.ReqBookInfo;
import work.metanet.api.book.protocol.ReqBookList;
import work.metanet.api.book.protocol.ReqBookList.RespBookList;
import work.metanet.api.book.protocol.ReqRemoveBook;
import work.metanet.api.book.protocol.ReqSaveBook;
import work.metanet.api.book.protocol.ReqSearchBook;
import work.metanet.api.book.protocol.ReqBookInfo.RespBookInfo;
import work.metanet.api.book.protocol.ReqSearchBook.RespSearchBook;
import work.metanet.base.RespPaging;

public interface IBookService {

	/**
	 * @Description: 课本列表
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	RespPaging<RespBookList> bookList(ReqBookList req) throws Exception;
	
	/**
	 * @Description: 导入课本
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	void saveBook(ReqSaveBook req) throws Exception;
	
	/**
	 * @Description: 课本信息
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/07/26
	 */
	RespBookInfo bookInfo(ReqBookInfo req) throws Exception;
	
	/**
	 * @Description: 删除课本
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	void removeBook(List<ReqRemoveBook> req) throws Exception;
	
	/**
	 * @Description: 搜索课本
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/07/13
	 */
	RespPaging<RespSearchBook> searchBook(ReqSearchBook req) throws Exception;
	
}
