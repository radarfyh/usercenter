package work.metanet.exception;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class MetanetException extends BaseException implements Serializable {

	private static final long serialVersionUID = 474072572861657259L;

	public static MetanetException of() {
		return new MetanetException();
	}
	
	public MetanetException() {
		super();
	}
	
	public MetanetException(String message) {
		super(message);
	}

	public MetanetException(Throwable cause) {
		super(cause);
	}

	public MetanetException(Integer code, String message) {
		super(code, message);
	}

	public MetanetException(String message, Throwable cause) {
		super(message, cause);
	}

	public MetanetException(Integer code, String message, Throwable cause) {
		super(code, message, cause);
	}
	
	public MetanetException setMsg(String msg) {
		setMessage(msg);
		return this;
	}
	
	public MetanetException setResult(ResultResponse<?> result) {
		setResultResponse(result);
		return this;
	}
}
