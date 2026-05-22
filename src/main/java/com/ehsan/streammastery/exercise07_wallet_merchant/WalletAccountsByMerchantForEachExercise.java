package com.ehsan.streammastery.exercise07_wallet_merchant;

import com.ehsan.streammastery.data.SampleData;
import com.ehsan.streammastery.model.Merchant;
import com.ehsan.streammastery.model.WalletAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WalletAccountsByMerchantForEachExercise {

    public static void main(String[] args) {
        List<WalletAccount> accounts = SampleData.walletAccounts();
        List<Merchant> merchants = SampleData.merchants();

        String inputMerchantId = "100";

        List<WalletAccount> filteredAccounts = new ArrayList<>();

        for (WalletAccount account : accounts) {
            if (account == null) {
                continue;
            }

            String groupCode = account.getGroupCode();

            if (groupCode == null || groupCode.isBlank()) {
                continue;
            }

            boolean merchantFound = false;

            for (Merchant merchant : merchants) {
                if (merchant == null) {
                    continue;
                }

                if (Objects.equals(merchant.getId(), inputMerchantId)
                        && Objects.equals(merchant.getGroupCode(), groupCode)) {
                    merchantFound = true;
                    break;
                }
            }

            if (merchantFound) {
                filteredAccounts.add(account);
            }
        }

        filteredAccounts.forEach(account ->
                System.out.println(account.getGroupCode() + " -> " + account.getBalance())
        );
    }
}
