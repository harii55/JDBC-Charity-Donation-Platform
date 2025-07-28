CREATE TABLE IF NOT EXISTS Donor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name TEXT,
    email TEXT,
    password TEXT,
    city TEXT,
    state TEXT,
    country TEXT,
    age INT,
    gender VARCHAR(10),
    income_range VARCHAR(50),
    created_at TIMESTAMP
);

CREATE TABLE IF NOT EXISTS Charity (
    charity_id INT AUTO_INCREMENT PRIMARY KEY,
    name TEXT,
    email TEXT,
    password TEXT,
    category TEXT,
    description TEXT,
    websiteUrl TEXT,
    ackUrl TEXT,
    receiptUrl TEXT,
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS Campaign (
    campaign_id INT AUTO_INCREMENT PRIMARY KEY,
    charity_id INT,
    title TEXT,
    category TEXT,
    description TEXT,
    rec_url TEXT,
    ack_url TEXT,
    is_active BOOLEAN DEFAULT TRUE,
    start_date DATE,
    end_date DATE,
    FOREIGN KEY (charity_id) REFERENCES Charity(charity_id)
);

CREATE TABLE IF NOT EXISTS FundraiserCampaign (
    fcampaign_id INT AUTO_INCREMENT PRIMARY KEY,
    charity_id INT NOT NULL,
    title TEXT NOT NULL,
    category TEXT,
    goal NUMERIC,
    start_date DATE,
    end_date DATE,
    is_active BOOLEAN DEFAULT TRUE,
    rec_url TEXT,
    ack_url TEXT,
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (charity_id) REFERENCES Charity(charity_id)
);

CREATE TABLE IF NOT EXISTS CampaignTransactions (
    transaction_id SERIAL PRIMARY KEY,
    donor_id INT NOT NULL,
    campaign_id INT NOT NULL,
    amount NUMERIC NOT NULL,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    receipt_status VARCHAR(50),
    FOREIGN KEY (donor_id) REFERENCES Donor(id),
    FOREIGN KEY (campaign_id) REFERENCES Campaign(campaign_id)
);

CREATE TABLE IF NOT EXISTS FundraiserTransactions (
    transaction_id SERIAL PRIMARY KEY,
    donor_id INT NOT NULL,
    fcampaign_id INT NOT NULL,
    amount NUMERIC NOT NULL,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    receipt_status VARCHAR(50),
    FOREIGN KEY (donor_id) REFERENCES Donor(id),
    FOREIGN KEY (fcampaign_id) REFERENCES FundraiserCampaign(fcampaign_id)
);

CREATE TABLE IF NOT EXISTS RecurringDonation (
    recurring_donation_id INT AUTO_INCREMENT PRIMARY KEY,
    donor_id INT NOT NULL,
    entity_type VARCHAR(20) NOT NULL,
    entity_id INT NOT NULL,
    charity_id INT NOT NULL,
    recurring_rate VARCHAR(20) NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    last_installment DATE,
    next_installment DATE,
    start_date DATE NOT NULL,
    end_date DATE,
    is_active BOOLEAN DEFAULT TRUE,
    primary_payment_method_id INT,

    FOREIGN KEY (donor_id) REFERENCES Donor(id),
    FOREIGN KEY (charity_id) REFERENCES Charity(charity_id)
    );
CREATE TABLE IF NOT EXISTS PaymentMethods (
                                id INT AUTO_INCREMENT PRIMARY KEY,
                                donor_id INT NOT NULL,
                                method_type ENUM('CARD', 'NETBANKING', 'UPI', 'WALLET') NOT NULL,
                                details JSON NOT NULL,
                                is_active BOOLEAN DEFAULT TRUE,
                                created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                FOREIGN KEY (donor_id) REFERENCES Donor(id)
);
CREATE TABLE IF NOT EXISTS FundraiserSummary (
    fcampaign_id INT PRIMARY KEY,
    total_amount_raised DECIMAL(12, 2) DEFAULT 0.00,
    last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (fcampaign_id) REFERENCES FundraiserCampaign(fcampaign_id)
    );

CREATE TABLE IF NOT EXISTS DonorDonationSummary (
                                                    donor_id INT NOT NULL,
                                                    donation_type VARCHAR(20) NOT NULL,
    total_amount DECIMAL(12,2) DEFAULT 0.00,
    donation_count INT DEFAULT 0,
    last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (donor_id, donation_type),
    FOREIGN KEY (donor_id) REFERENCES Donor(id)
    );

CREATE TABLE IF NOT EXISTS ContactPreference(
    id INT AUTO_INCREMENT PRIMARY KEY,
    donor_id INT NOT NULL,
    contact_via VARCHAR(50) NOT NULL,
    value VARCHAR(255) NOT NULL,
    pref_rank INT DEFAULT 1,
    is_active BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (donor_id) REFERENCES Donor(id)
    );