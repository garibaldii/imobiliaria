package controller;

import model.Contract;

import java.util.ArrayList;
import java.util.List;

public class ContractController {

    List<Contract> contracts = new ArrayList<>();



    public Contract postContract(Contract c) {
        contracts.add(c);
        return c;
    }
}
