package com.editor;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.model.Member;
import com.service.MemberService;
@Component
public class MemberEditor extends PropertyEditorSupport {

	public MemberEditor() {
	}

	 @Autowired
	    private MemberService memberService;

	    // Converts a String team id to a Team (when submitting form)
	    @Override
	    public void setAsText(String text) {
	       Member m = this.memberService.getMember(Integer.valueOf(text));

	        this.setValue(m);
	    }
}
