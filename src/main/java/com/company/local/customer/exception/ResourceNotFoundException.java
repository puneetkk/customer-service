package com.company.local.customer.exception;

public class ResourceNotFoundException extends RuntimeException {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1121315507091901087L;
	private Long resourceId;
 
    public ResourceNotFoundException(Long resourceId, String message) {
        super(message);
        this.setResourceId(resourceId);
    }

	public Long getResourceId() {
		return resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}
}