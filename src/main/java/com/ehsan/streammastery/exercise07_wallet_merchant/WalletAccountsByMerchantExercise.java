package com.ehsan.streammastery.exercise07_wallet_merchant;

import com.ehsan.streammastery.data.SampleData;
import com.ehsan.streammastery.model.Merchant;
import com.ehsan.streammastery.model.WalletAccount;

import java.util.List;
import java.util.Objects;

public class WalletAccountsByMerchantExercise {

    public static void main(String[] args) {

        List<WalletAccount> accounts = SampleData.accounts();
        List<Merchant> merchants = SampleData.merchants();
        String inputMerchantId = "100";

        List<WalletAccount> filteredAccounts = accounts.stream()
                .filter(account ->
                        account != null
                                && account.getGroupCode() != null
                                && !account.getGroupCode().isBlank()
                )
                .filter(account -> merchants.stream()
                        .anyMatch(merchant ->
                                merchant != null
                                        && Objects.equals(merchant.getGroupCode(), account.getGroupCode())
                                        && Objects.equals(merchant.getId(), inputMerchantId)
                        )
                )
                .toList();

        filteredAccounts.forEach(account ->
                System.out.println(account.getGroupCode() + " - " + account.getBalance())
        );
    }
}
