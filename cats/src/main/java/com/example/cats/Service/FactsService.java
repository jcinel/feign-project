package com.example.cats.Service;

import com.example.cats.Client.FactsClient;
import com.example.cats.DTO.FactsDTO;
import com.example.cats.Error.Exception.*;
import com.example.cats.Exception.UnexpectedErrorException;
import com.example.cats.Exception.UnknownErrorException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactsService {

    private final FactsClient factsClient;

    public FactsService(FactsClient factsClient) {
        this.factsClient = factsClient;
    }

    public List<FactsDTO> getFacts() {
        try {
            return this.factsClient.getFacts();
        } catch (FactsException ex) {
            if (ex.getErrorCode() == FactsErrorCode.UNAVAILABLE) {
                throw new FactsServiceUnavailableException(ex.getErrorCode());
            }
            throw ex;
        } catch (FactsUnknownErrorException ex) {
            System.out.println("Unknown error while fetching facts, code " + ex.getErrorCode());
            throw new UnknownErrorException(ex.getErrorCode());
        } catch (FactsUnexpectedErrorException ex) {
            System.out.println("Unexpected error while fetching facts");
            throw new UnexpectedErrorException();
        }
    }
}
