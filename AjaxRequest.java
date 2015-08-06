public Class AjaxRequest {
	
	/**
	* 判断是否是Ajax请求
	*/
	public boolean isAjax(HttpServletRequest request, HttpServletResponse response) {
		String requestType = request.getHeader("X-Requested-With");
		if (requestType != null && requestType.equalsIgnoreCase("XMLHttpRequest")) {
			response.addHeader("loginStatus", "accessDenied");
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
			return false;
		} else {
			if (request.getMethod().equalsIgnoreCase("GET")) {
				String redirectUrl = request.getQueryString() != null ? request.getRequestURI() + "?" + request.getQueryString() : request.getRequestURI();
				response.sendRedirect(loginUrl + "&" + REDIRECT_URL_PARAMETER_NAME + "=" + URLEncoder.encode(redirectUrl, urlEscapingCharset));
			} else {
				response.sendRedirect(loginUrl);
			}
			return false;
		}
		
	}
	
	
}