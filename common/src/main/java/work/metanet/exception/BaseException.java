package work.metanet.exception;

import java.io.Serializable;
import java.util.Objects;

import lombok.NonNull;

public class BaseException extends RuntimeException implements Serializable {
	private static final long serialVersionUID = 7743788227174142875L;
	
	@NonNull
	private ResultResponse<?> resultResponse;
	
	public BaseException() {
		super(ResultResponseEnum.SERVER_FAILURE.getMessage());
		this.resultResponse = new ResultResponse<Object>();
		resultResponse.setResponseCode(ResultResponseEnum.SERVER_FAILURE.getResponseCode());
		resultResponse.setMessage(ResultResponseEnum.SERVER_FAILURE.getMessage());
	}
	
	public BaseException(ResultResponse<Object> resultResponse) {
		super(resultResponse.getMessage());
		this.resultResponse = resultResponse;
	}
	
	public BaseException(String message) {
		super(message);
		this.resultResponse = new ResultResponse<Object>();
		resultResponse.setResponseCode(ResultResponseEnum.SERVER_FAILURE.getResponseCode());
		resultResponse.setMessage(message);
	}
	
	public BaseException(Throwable cause) {
		super(cause);
		this.resultResponse = new ResultResponse<Object>();
		resultResponse.setResponseCode(ResultResponseEnum.SERVER_FAILURE.getResponseCode());
		resultResponse.setMessage(ResultResponseEnum.SERVER_FAILURE.getMessage());
	}
	
	public BaseException(Integer code, String message) {
		super(message);
		this.resultResponse = new ResultResponse<Object>();
		resultResponse.setResponseCode(code);
		resultResponse.setMessage(message);
	}
	
	public BaseException(String message, Throwable cause) {
		super(message, cause);
		this.resultResponse = new ResultResponse<Object>();
		resultResponse.setResponseCode(ResultResponseEnum.SERVER_FAILURE.getResponseCode());
		resultResponse.setMessage(message);
	}
	
	public BaseException(Integer code, String message, Throwable cause) {
		super(message, cause);
		this.resultResponse = new ResultResponse<Object>();
		resultResponse.setResponseCode(code);
		resultResponse.setMessage(message);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseException other = (BaseException) obj;
		return Objects.equals(resultResponse.getMessage(), other.resultResponse.getMessage()) 
				&& Objects.equals(resultResponse.getResponseCode(), other.resultResponse.getResponseCode());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(resultResponse.getMessage(), resultResponse.getResponseCode());
	}

	@Override
	public String toString() {
		return "BaseException [responseCode=" + resultResponse.getResponseCode() 
			+ ", message=" + resultResponse.getMessage() + "]";
	}

	public Integer getResponseCode() {
		return resultResponse.getResponseCode();
	}

	public void setResponseCode(Integer responseCode) {
		resultResponse.setResponseCode(responseCode);
	}

	public String getMessage() {
		return resultResponse.getMessage();
	}

	public void setMessage(String message) {
		resultResponse.setMessage(message);
	}
	
	public Boolean getSuccessFlag() {
		return resultResponse.getSuccessFlag();
	}

	public void setSuccessFlag(Boolean flag) {
		resultResponse.setSuccessFlag(flag);
	}
	
	public ResultResponse<?> getResultResponse() {
		return resultResponse;
	}

	public void setResultResponse(ResultResponse<?> result) {
		resultResponse = result;
	}
}
