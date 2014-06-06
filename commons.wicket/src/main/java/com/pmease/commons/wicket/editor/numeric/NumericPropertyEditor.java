package com.pmease.commons.wicket.editor.numeric;

import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.convert.ConversionException;

import com.pmease.commons.editable.PropertyDescriptor;
import com.pmease.commons.wicket.editor.ErrorContext;
import com.pmease.commons.wicket.editor.PathSegment;
import com.pmease.commons.wicket.editor.PropertyEditor;

@SuppressWarnings("serial")
public class NumericPropertyEditor extends PropertyEditor<Number> {

	private TextField<Number> input;
	
	public NumericPropertyEditor(String id, PropertyDescriptor propertyDescriptor, IModel<Number> propertyModel) {
		super(id, propertyDescriptor, propertyModel);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		
		input = new TextField<Number>("input", getModel());
		input.setType(getPropertyDescriptor().getPropertyClass());
		add(input);
	}

	@Override
	public ErrorContext getErrorContext(PathSegment pathSegment) {
		return null;
	}

	@Override
	protected Number convertInputToValue() throws ConversionException {
		return input.getConvertedInput();
	}

}