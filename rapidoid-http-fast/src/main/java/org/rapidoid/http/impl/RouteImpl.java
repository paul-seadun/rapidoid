package org.rapidoid.http.impl;

import org.rapidoid.annotation.Authors;
import org.rapidoid.annotation.Since;
import org.rapidoid.http.HttpVerb;
import org.rapidoid.http.Route;
import org.rapidoid.http.handler.HttpHandler;
import org.rapidoid.u.U;

@Authors("Nikolche Mihajlovski")
@Since("5.1.0")
public class RouteImpl implements Route {

	private HttpVerb verb;

	private String path;

	private HttpHandler handler;

	public RouteImpl(HttpVerb verb, String path, HttpHandler handler) {
		this.verb = verb;
		this.path = path;
		this.handler = handler;
	}

	@Override
	public HttpVerb verb() {
		return verb;
	}

	@Override
	public String path() {
		return path;
	}

	@Override
	public HttpHandler handler() {
		return handler;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		RouteImpl route = (RouteImpl) o;

		if (verb != route.verb) return false;
		return path.equals(route.path);

	}

	@Override
	public String toString() {
		return U.frmt("Route %s %s : %s", verb, path, handler);
	}

	@Override
	public int hashCode() {
		int result = verb.hashCode();
		result = 31 * result + path.hashCode();
		return result;
	}
}
