package com.company.application.rule;

import java.util.List;

public interface Rule<I,O> {
	
	public List<O> process();
	public boolean matches(I input);
}	