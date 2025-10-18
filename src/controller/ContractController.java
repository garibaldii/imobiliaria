package controller;

import model.Contract;
import service.ContractService;

import java.util.ArrayList;
import java.util.List;

public class ContractController {

    List<Contract> contracts = new ArrayList<>();

    ContractService service = new ContractService();

    public Contract postContract(Contract c) {
        service.verifyFeeDiscount(c);
        contracts.add(c);
        return c;
    }
}
