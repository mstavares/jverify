package pt.mstavares.verify.services;


import org.springframework.web.bind.annotation.*;
import pt.mstavares.jkyc.gateways.ptcc.api.PtCCApi;
import pt.mstavares.jkyc.logic.ptcc.verifiers.sod.exceptions.SODVerifierException;
import pt.mstavares.jkyc.logic.ptcc.verifiers.wallet.exceptions.WalletAddressVerifierException;
import pt.mstavares.jkyc.logic.ptcc.verifiers.x509certificate.exceptions.CertificateChainException;
import pt.mstavares.jkyc.logic.ptcc.verifiers.x509certificate.exceptions.CertificateRevokedException;
import pt.mstavares.verify.models.Response;

import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

@RestController
public class VerifyService {

    @CrossOrigin
    @RequestMapping(method= RequestMethod.POST, consumes= MediaType.APPLICATION_JSON)
    public Response verify(@RequestBody String dataID) {
        try {
            PtCCApi api = new PtCCApi();
            api.verify(dataID);
        } catch (CertificateRevokedException | SODVerifierException | WalletAddressVerifierException |
                CertificateChainException | NoSuchAlgorithmException | CertificateException | KeyStoreException | IOException ex) {
            return new Response(false, ex.getMessage());
        }
        return new Response(true);
    }

}
