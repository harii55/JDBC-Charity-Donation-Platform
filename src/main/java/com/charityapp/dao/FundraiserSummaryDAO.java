package main.java.com.charityapp.dao;

import java.math.BigDecimal;
import java.sql.SQLException;

public interface FundraiserSummaryDAO {
    void updateFundraiserSummary(int fcampaignId, BigDecimal amount) throws SQLException;
}
