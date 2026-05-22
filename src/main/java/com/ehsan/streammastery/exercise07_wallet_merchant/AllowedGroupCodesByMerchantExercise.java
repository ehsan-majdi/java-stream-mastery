package com.ehsan.streammastery.exercise07_wallet_merchant;

import com.ehsan.streammastery.data.SampleData;
import com.ehsan.streammastery.model.Merchant;
import com.ehsan.streammastery.model.WalletAccount;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class AllowedGroupCodesByMerchantExercise {

    public static void main(String[] args) {
        List<WalletAccount> accounts = SampleData.walletAccounts();
        List<Merchant> merchants = SampleData.merchants();

        String inputMerchantId = "100";

        Set<String> allowedGroupCodes = merchants.stream()
                .filter(merchant ->
                        merchant != null
                                && Objects.equals(merchant.getId(), inputMerchantId)
                                && merchant.getGroupCode() != null
                                && !merchant.getGroupCode().isBlank()
                )
                .map(Merchant::getGroupCode)
                .collect(Collectors.toSet());

        List<WalletAccount> filteredAccounts = accounts.stream()
                .filter(account ->
                        account != null
                                && account.getGroupCode() != null
                                && !account.getGroupCode().isBlank()
                                && allowedGroupCodes.contains(account.getGroupCode())
                )
                .toList();

        filteredAccounts.forEach(account ->
                System.out.println(account.getGroupCode() + " -> " + account.getBalance())
        );
    }
}
