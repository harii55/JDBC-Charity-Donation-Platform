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
