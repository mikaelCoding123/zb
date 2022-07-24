package generate;

import generate.Wallet;

public interface WalletDao {
    int insert(Wallet record);

    int insertSelective(Wallet record);
}