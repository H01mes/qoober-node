/*
 * Copyright © 2013-2016 The Qoober Core Developers.
 * Copyright © 2016-2020 Jelurida IP B.V.
 *
 * See the LICENSE.txt file at the top-level directory of this distribution
 * for licensing information.
 *
 * Unless otherwise agreed in a custom licensing agreement with Jelurida B.V.,
 * no part of the Qoober software, including this file, may be copied, modified,
 * propagated, or distributed except according to the terms contained in the
 * LICENSE.txt file.
 *
 * Removal or modification of this copyright notice is prohibited.
 *
 */

package qoober;

import java.math.BigInteger;

public final class Constants {

    public static final boolean isTestnet = Qoober.getBooleanProperty("qoober.isTestnet");
    public static final boolean isOffline = Qoober.getBooleanProperty("qoober.isOffline");
    public static final boolean isLightClient = Qoober.getBooleanProperty("qoober.isLightClient");
    public static final boolean isAutomatedTest = isTestnet && Qoober.getBooleanProperty("qoober.isAutomatedTest");
    public static final String customLoginWarning = Qoober.getStringProperty("qoober.customLoginWarning", null, false, "UTF-8");

    public static final String COIN_SYMBOL = "QOOB";
    public static final String ACCOUNT_PREFIX = "QOOB";
    public static final String PROJECT_NAME = "QOOBER";
    public static final int MAX_NUMBER_OF_TRANSACTIONS = Qoober.getIntProperty("qoober.maxNumberOfTransactions", 255);
    public static final int MIN_TRANSACTION_SIZE = 176;
    public static final int MAX_PAYLOAD_LENGTH = MAX_NUMBER_OF_TRANSACTIONS * MIN_TRANSACTION_SIZE;
    public static final long INIT_BALANCE_QBR = 7000000;
    public static final long MAX_BALANCE_QBR = 7000000000L;
    public static final long ONE_QBR = 100;
    public static final long MAX_BALANCE_QNT = MAX_BALANCE_QBR * ONE_QBR;

    public static final int BLOCK_TIME = 60;
    public static final long INITIAL_BASE_TARGET = BigInteger.valueOf(2).pow(63).divide(BigInteger.valueOf(BLOCK_TIME * INIT_BALANCE_QBR)).longValue();
    public static final long MAX_BASE_TARGET = INITIAL_BASE_TARGET * (isTestnet ? MAX_BALANCE_QBR : 50);
    public static final long MIN_BASE_TARGET = INITIAL_BASE_TARGET * 9 / 10000;
    public static final int MIN_BLOCKTIME_LIMIT = BLOCK_TIME - 7;
    public static final int MAX_BLOCKTIME_LIMIT = BLOCK_TIME + 7;
    public static final int BASE_TARGET_GAMMA = 64;
    public static final int MAX_ROLLBACK = Math.max(Qoober.getIntProperty("qoober.maxRollback"), 720);
    public static final int GUARANTEED_BALANCE_CONFIRMATIONS = isTestnet ? Qoober.getIntProperty("qoober.testnetGuaranteedBalanceConfirmations", 1440) : 1440;
    public static final int LEASING_DELAY = isTestnet ? Qoober.getIntProperty("qoober.testnetLeasingDelay", 1440) : 1440;
    public static final long MIN_FORGING_BALANCE_QNT = 1000 * ONE_QBR;

    // Paramining parameters
    public static final long MIN_PARAMINING_BALANCE_QNT = 100 * ONE_QBR;
    public static final long MAX_PARAMINING_BALANCE_QNT = 1000000 * ONE_QBR;
    public static final int MAX_ACCOUNT_STRUCT_SIZE = isTestnet ? Qoober.getIntProperty("qoober.testnetMaxAccountStructSize", 77) : 77;
    public static final int PARAMINING_REINVEST_INTERVAL = isTestnet ? Qoober.getIntProperty("qoober.testnetParaminingReinvestInterval", 1440) : 1440;

    public static final int MAX_TIMEDRIFT = 15; // allow up to 15 s clock difference
    public static final int FORGING_DELAY = Qoober.getIntProperty("qoober.forgingDelay");
    public static final int FORGING_SPEEDUP = Qoober.getIntProperty("qoober.forgingSpeedup");
    public static final int BATCH_COMMIT_SIZE = Qoober.getIntProperty("qoober.batchCommitSize", Integer.MAX_VALUE);

    public static final byte MAX_PHASING_VOTE_TRANSACTIONS = 10;
    public static final byte MAX_PHASING_WHITELIST_SIZE = 10;
    public static final byte MAX_PHASING_LINKED_TRANSACTIONS = 10;
    public static final int MAX_PHASING_DURATION = 14 * 1440;
    public static final int MAX_PHASING_REVEALED_SECRET_LENGTH = 100;

    public static final int MAX_ALIAS_URI_LENGTH = 1000;
    public static final int MAX_ALIAS_LENGTH = 100;

    public static final int MAX_ARBITRARY_MESSAGE_LENGTH = 160;
    public static final int MAX_ENCRYPTED_MESSAGE_LENGTH = 160 + 16;

    public static final int MAX_PRUNABLE_MESSAGE_LENGTH = 42 * 1024;
    public static final int MAX_PRUNABLE_ENCRYPTED_MESSAGE_LENGTH = 42 * 1024;

    public static final int MIN_PRUNABLE_LIFETIME = isTestnet ? 1440 * 60 : 14 * 1440 * 60;
    public static final int MAX_PRUNABLE_LIFETIME;
    public static final boolean ENABLE_PRUNING;
    static {
        int maxPrunableLifetime = Qoober.getIntProperty("qoober.maxPrunableLifetime");
        ENABLE_PRUNING = maxPrunableLifetime >= 0;
        MAX_PRUNABLE_LIFETIME = ENABLE_PRUNING ? Math.max(maxPrunableLifetime, MIN_PRUNABLE_LIFETIME) : Integer.MAX_VALUE;
    }
    public static final boolean INCLUDE_EXPIRED_PRUNABLE = Qoober.getBooleanProperty("qoober.includeExpiredPrunable");

    public static final int MAX_ACCOUNT_NAME_LENGTH = 100;
    public static final int MAX_ACCOUNT_DESCRIPTION_LENGTH = 1000;

    public static final int MAX_ACCOUNT_PROPERTY_NAME_LENGTH = 32;
    public static final int MAX_ACCOUNT_PROPERTY_VALUE_LENGTH = 160;
    public static final int MAX_ASSET_PROPERTY_NAME_LENGTH = 32;
    public static final int MAX_ASSET_PROPERTY_VALUE_LENGTH = 160;

    public static final long MAX_ASSET_QUANTITY_QNT = 1000000000L * 100000000L;
    public static final int MIN_ASSET_NAME_LENGTH = 3;
    public static final int MAX_ASSET_NAME_LENGTH = 10;
    public static final int MAX_ASSET_DESCRIPTION_LENGTH = 1000;
    public static final int MAX_SINGLETON_ASSET_DESCRIPTION_LENGTH = 160;
    public static final int MAX_ASSET_TRANSFER_COMMENT_LENGTH = 1000;
    public static final int MAX_DIVIDEND_PAYMENT_ROLLBACK = 1441;

    public static final int MAX_POLL_NAME_LENGTH = 100;
    public static final int MAX_POLL_DESCRIPTION_LENGTH = 1000;
    public static final int MAX_POLL_OPTION_LENGTH = 100;
    public static final int MAX_POLL_OPTION_COUNT = 100;
    public static final int MAX_POLL_DURATION = 14 * 1440;

    public static final byte MIN_VOTE_VALUE = -92;
    public static final byte MAX_VOTE_VALUE = 92;
    public static final byte NO_VOTE_VALUE = Byte.MIN_VALUE;

    public static final int MAX_DGS_LISTING_QUANTITY = 1000000000;
    public static final int MAX_DGS_LISTING_NAME_LENGTH = 100;
    public static final int MAX_DGS_LISTING_DESCRIPTION_LENGTH = 1000;
    public static final int MAX_DGS_LISTING_TAGS_LENGTH = 100;
    public static final int MAX_DGS_GOODS_LENGTH = 1000;

    public static final int MIN_CURRENCY_NAME_LENGTH = 3;
    public static final int MAX_CURRENCY_NAME_LENGTH = 10;
    public static final int MIN_CURRENCY_CODE_LENGTH = 3;
    public static final int MAX_CURRENCY_CODE_LENGTH = 5;
    public static final int MAX_CURRENCY_DESCRIPTION_LENGTH = 1000;
    public static final long MAX_CURRENCY_TOTAL_SUPPLY = 1000000000L * 100000000L;
    public static final int MAX_MINTING_RATIO = 10000; // per mint units not more than 0.01% of total supply
    public static final byte MIN_NUMBER_OF_SHUFFLING_PARTICIPANTS = 3;
    public static final byte MAX_NUMBER_OF_SHUFFLING_PARTICIPANTS = 30; // max possible at current block payload limit is 51
    public static final short MAX_SHUFFLING_REGISTRATION_PERIOD = (short)1440 * 7;
    public static final short SHUFFLING_PROCESSING_DEADLINE = (short)(isTestnet ? 10 : 100);

    public static final int MAX_TAGGED_DATA_NAME_LENGTH = 100;
    public static final int MAX_TAGGED_DATA_DESCRIPTION_LENGTH = 1000;
    public static final int MAX_TAGGED_DATA_TAGS_LENGTH = 100;
    public static final int MAX_TAGGED_DATA_TYPE_LENGTH = 100;
    public static final int MAX_TAGGED_DATA_CHANNEL_LENGTH = 100;
    public static final int MAX_TAGGED_DATA_FILENAME_LENGTH = 100;
    public static final int MAX_TAGGED_DATA_DATA_LENGTH = 42 * 1024;

    public static final int MAX_REFERENCED_TRANSACTION_TIMESPAN = 60 * 1440 * 60;
    public static final int CHECKSUM_BLOCK_1 = Integer.MAX_VALUE;

    public static final int LAST_CHECKSUM_BLOCK = 0;
    // LAST_KNOWN_BLOCK must also be set in html/www/js/nrs.constants.js
    public static final int LAST_KNOWN_BLOCK = isTestnet ? 0 : 0;

    public static final int[] MIN_VERSION = new int[] {1, 0, 1};
    public static final int[] MIN_PROXY_VERSION = new int[] {1, 0, 1};

    static final long UNCONFIRMED_POOL_DEPOSIT_QNT = (isTestnet ? 50 : 100) * ONE_QBR;
    public static final long SHUFFLING_DEPOSIT_QNT = (isTestnet ? 7 : 1000) * ONE_QBR;

    public static final boolean correctInvalidFees = Qoober.getBooleanProperty("qoober.correctInvalidFees");

    public static final String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyz";
    public static final String ALLOWED_CURRENCY_CODE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static final boolean DISABLE_FULL_TEXT_SEARCH = Qoober.getBooleanProperty("qoober.disableFullTextSearch");
    public static final boolean DISABLE_METADATA_DETECTION = Qoober.getBooleanProperty("qoober.disableMetadataDetection");

    private Constants() {} // never

}
