package com.secondstep.GWTCheckBox.client;

import com.secondstep.GWTCheckBox.shared.FieldVerifier;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CheckBox_GWT implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network " + "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
	
	/**
	 * This is the entry point method.
	 */
	private static class InnerCheckBox extends Composite {
		private VerticalPanel vPanel = new VerticalPanel();
		private CheckBox checkBox = new CheckBox();
		public InnerCheckBox(HTML label , String [] daysOfWeek )
		{
			 vPanel.add(label);
			 for (int i = 0; i < daysOfWeek.length; i++) {
			        String day = daysOfWeek[i];
			        checkBox = new CheckBox(day);
			        checkBox.ensureDebugId("cwCheckBox-" + day);

			        vPanel.add(checkBox);
			      }
			 initWidget(vPanel);
		}
		
	}
	public void onModuleLoad() {
		HTML label = new HTML("Check all Programming Language that you are Good at:\r\n" );
	    label.ensureDebugId("CheckBox-label");
	    
	    String[] daysOfWeek = {"Java","C#","C++","Python","SQL","PHP","Ruby"};
	    InnerCheckBox box= new InnerCheckBox(label, daysOfWeek);
	    
	  
	    RootPanel.get().add(box);
	}
}
