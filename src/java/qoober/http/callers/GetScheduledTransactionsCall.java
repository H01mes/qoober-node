// Auto generated code, do not modify
package qoober.http.callers;

import qoober.http.APICall;

public class GetScheduledTransactionsCall extends APICall.Builder<GetScheduledTransactionsCall> {
    private GetScheduledTransactionsCall() {
        super(ApiSpec.getScheduledTransactions);
    }

    public static GetScheduledTransactionsCall create() {
        return new GetScheduledTransactionsCall();
    }

    public GetScheduledTransactionsCall account(String account) {
        return param("account", account);
    }

    public GetScheduledTransactionsCall account(long account) {
        return unsignedLongParam("account", account);
    }
}
