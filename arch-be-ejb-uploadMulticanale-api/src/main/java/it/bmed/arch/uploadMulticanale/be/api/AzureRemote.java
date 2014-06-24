package it.bmed.arch.uploadMulticanale.be.api;

import java.rmi.Remote;
import java.rmi.RemoteException;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface AzureRemote extends Remote {

	public AzureResponse getAzureToken(AzureRequest parameters)
			throws RemoteException, Exception;

}
