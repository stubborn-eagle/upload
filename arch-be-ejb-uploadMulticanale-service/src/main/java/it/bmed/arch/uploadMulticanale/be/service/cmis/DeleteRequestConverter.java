/**
 * 
 */
package it.bmed.arch.uploadMulticanale.be.service.cmis;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

/**
 * @author donatello.boccaforno
 *
 */
public class DeleteRequestConverter implements Converter {

	/* (non-Javadoc)
	 * @see com.thoughtworks.xstream.converters.ConverterMatcher#canConvert(java.lang.Class)
	 */
	@Override
	public boolean canConvert(Class type) {
		return type.equals(DeleteRequest.class);
	}

	/* (non-Javadoc)
	 * @see com.thoughtworks.xstream.converters.Converter#marshal(java.lang.Object, com.thoughtworks.xstream.io.HierarchicalStreamWriter, com.thoughtworks.xstream.converters.MarshallingContext)
	 */
	@Override
	public void marshal(Object source, HierarchicalStreamWriter writer,
			MarshallingContext context) {
		DeleteRequest request = (DeleteRequest) source;
		setObjectStore(writer, request.getObjectStore().getValue());
		setObjectClass(writer, request.getObjectClass().getValue());
		setIndex(writer, request.getIndex());
		setForceDeleteSubDocuments(writer, request.getForceDeleteSubDocuments().getValue());
	}

	/* (non-Javadoc)
	 * @see com.thoughtworks.xstream.converters.Converter#unmarshal(com.thoughtworks.xstream.io.HierarchicalStreamReader, com.thoughtworks.xstream.converters.UnmarshallingContext)
	 */
	@Override
	public Object unmarshal(HierarchicalStreamReader reader,
			UnmarshallingContext context) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void setObjectStore(HierarchicalStreamWriter writer, String  objectStoreValue) {
		writer.startNode("ObjectStore");
		if (objectStoreValue != null && objectStoreValue.length() > 0) {
			writer.addAttribute("value", objectStoreValue);
		} else {
			writer.addAttribute("value", "");
		}
		writer.endNode();
	}
	
	private void setObjectClass(HierarchicalStreamWriter writer, String objectClassValue) {
		writer.startNode("ObjectClass");
		if (objectClassValue != null && objectClassValue.length() > 0) {
			writer.addAttribute("value", objectClassValue);
		} else {
			writer.addAttribute("value", "");
		}
		writer.endNode();
	}
	
	private void setIndex(HierarchicalStreamWriter writer, IndexDelete index) {
		writer.startNode("Index");
		if(index != null) {			
			writer.addAttribute("name", (index.getName() != null && index.getName().length() > 0 ? index.getName() : "") );
			writer.addAttribute("operator", (index.getOperator() != null && index.getOperator().length() > 0 ? index.getOperator() : ""));
			writer.addAttribute("value", index.getValue() != null && index.getValue().length() > 0 ? index.getValue() : "");
		} else {
			writer.addAttribute("name", "ID");
			writer.addAttribute("operator", "=");
			writer.addAttribute("value", "");			
		}
		writer.endNode();
	}

	private void setForceDeleteSubDocuments(HierarchicalStreamWriter writer,
			String value) {
		writer.startNode("ForceDeleteSubDocuments");
		if(value != null && value.length() > 0) {			
			writer.addAttribute(value, value);
		} else {
			writer.addAttribute(value, "");
		}
		writer.endNode();
		
	}

}
