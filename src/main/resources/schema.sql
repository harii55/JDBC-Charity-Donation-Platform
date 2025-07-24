-- =========================
-- Table: Donors
-- =========================
CREATE TABLE Donor (
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