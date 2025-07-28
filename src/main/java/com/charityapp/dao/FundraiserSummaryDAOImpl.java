package main.java.com.charityapp.dao;
import main.java.com.charityapp.db.dbUtil;

import java.math.BigDecimal;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FundraiserSummaryDAOImpl implements FundraiserSummaryDAO {

    private final Connection conn;

    public FundraiserSummaryDAOImpl() throws SQLException {
        this.conn = dbUtil.getConnection();
    }

    @Override
    public void updateFundraiserSummary(int fcampaignId, BigDecimal amount) throws SQLException {
        String sql = "INSERT INTO FundraiserSummary (fcampaign_id, total_amount_raised) " +
                "VALUES (?, ?) " +
                "ON DUPLICATE KEY UPDATE total_amount_raised = total_amount_raised + VALUES(total_amount_raised), " +
                "last_updated = CURRENT_TIMESTAMP";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, fcampaignId);
            stmt.setBigDecimal(2, new BigDecimal(String.valueOf(amount)));
            stmt.executeUpdate();
        }
    }
}
