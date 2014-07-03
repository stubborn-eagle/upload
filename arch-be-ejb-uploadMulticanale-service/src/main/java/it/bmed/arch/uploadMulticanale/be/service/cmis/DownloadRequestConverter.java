package it.bmed.arch.uploadMulticanale.be.service.cmis;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class DownloadRequestConverter implements Converter {

	@Override
	public boolean canConvert(Class type) {
		return type.equals(DownloadRequest.class);
	}

	@Override
	public void marshal(Object source, HierarchicalStreamWriter writer,
			MarshallingContext context) {
		DownloadRequest request = (DownloadRequest) source;
		setObjectStore(writer, request.getObjectStore().getValue());
		setObjectClass(writer, request.getObjectClass().getValue());
		setIndex(writer, request.getIndex());
		setConvert(writer, request.getConvert().getValue());
		setMatricola(writer, request.getMatricola().getValue());
		setIstituto(writer, request.getIstituto().getValue());
		setFiliale(writer, request.getFiliale().getValue());
		setPdfDisablePrint(writer, request.getPdfDisablePrint().getValue());
		setRuolo(writer, request.getRuolo().getValue());
	}

	private void setRuolo(HierarchicalStreamWriter writer, String ruoloValue) {
		writer.startNode("Ruolo");
		if (ruoloValue != null && ruoloValue.length() > 0) {
			writer.addAttribute("value", ruoloValue);
		} else {
			writer.addAttribute("value", "");
		}
		writer.endNode();
	}

	private void setPdfDisablePrint(HierarchicalStreamWriter writer,
			String pdfDisablePrintValue) {
		writer.startNode("PdfDisablePrint");
		if (pdfDisablePrintValue != null && pdfDisablePrintValue.length() > 0) {
			writer.addAttribute("value", pdfDisablePrintValue);
		} else {
			writer.addAttribute("value", "");
		}
		writer.endNode();
	}

	private void setFiliale(HierarchicalStreamWriter writer, String filialeValue) {
		writer.startNode("Filiale");
		if (filialeValue != null && filialeValue.length() > 0) {
			writer.addAttribute("value", filialeValue);
		} else {
			writer.addAttribute("value", "");
		}
		writer.endNode();
	}

	private void setIstituto(HierarchicalStreamWriter writer, String istitutoValue) {
		writer.startNode("Istituto");
		if (istitutoValue != null && istitutoValue.length() > 0) {
			writer.addAttribute("value", istitutoValue);
		} else {
			writer.addAttribute("value", "");
		}
		writer.endNode();
	}

	private void setMatricola(HierarchicalStreamWriter writer, String matricolaValue) {
		writer.startNode("Matricola");
		if (matricolaValue != null && matricolaValue.length() > 0) {
			writer.addAttribute("value", matricolaValue);
		} else {
			writer.addAttribute("value", "");
		}
		writer.endNode();
	}

	private void setConvert(HierarchicalStreamWriter writer, String convertValue) {
		writer.startNode("Convert");
		if (convertValue != null && convertValue.length() > 0) {
			writer.addAttribute("value", convertValue);
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

	private void setObjectClass(HierarchicalStreamWriter writer, String objectClassValue) {
		writer.startNode("ObjectClass");
		if (objectClassValue != null && objectClassValue.length() > 0) {
			writer.addAttribute("value", objectClassValue);
		} else {
			writer.addAttribute("value", "");
		}
		writer.endNode();
	}

	private void setObjectStore(HierarchicalStreamWriter writer, String objectStoreValue) {
		writer.startNode("ObjectStore");
		if (objectStoreValue != null && objectStoreValue.length() > 0) {
			writer.addAttribute("value", objectStoreValue);
		} else {
			writer.addAttribute("value", "");
		}
		writer.endNode();
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader,
			UnmarshallingContext context) {
		// TODO Auto-generated method stub
		return null;
	}

}
