# WebViewController
WebViewController gives an easy way to intercept Android's WebView requests. It also standardizes the different forms of resource handling existent in each version of Android's SDK.

There are three main steps for using WebViewController:

1. Instantiate the `Interceptor` class
2. Add the path intended to be intercepted with a overridden interface of `RequestProcessor`
3. Set the `WebViewClient` of your `WebView` with product of `WebViewClientFactory`

```
Interceptor interceptor = new Interceptor();
interceptor.addHandler("/test", new RequestProcessor() {
	@Override
	public Response process(Request request) {
		TagComposite html = new TagComposite("html");
		html.addChild((new TagComposite("head")).addChild((new Tag("title")).setValue("Test")))
			.addChild((new TagComposite("body")).addChild(new Tag("h1").setValue("TEST OK")));
		Response response = new Response();
		response.setStatusCode(200)
				.setReasonPhrase("OK")
				.setData(new ByteArrayInputStream(html.getValue().getBytes()))
				.getHeaders().add("Content-type","text/html");
		return response;
	}
});
webview.setWebViewClient(WebViewClientFactory.create(interceptor));
```


