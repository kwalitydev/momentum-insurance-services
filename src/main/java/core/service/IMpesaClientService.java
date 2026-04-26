package core.service;

import core.beans.MpesaRequest;
import core.beans.MpesaResponse;

public interface IMpesaClientService {
     MpesaResponse callMpesa(MpesaRequest requestDto);
}
