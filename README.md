# Charity Donation Platform

A comprehensive Java-based platform for managing charitable donations, campaigns, and fundraising activities. This platform provides a robust backend system for connecting donors with charities and managing donation transactions.

## 🎯 Project Overview

The Charity Donation Platform is a full-featured donation management system built with Java, MySQL, and Gradle. It provides a complete solution for charities to manage campaigns, donors to make donations, and administrators to track and report on donation activities.

## ✨ Features

### Core Functionality

- **Donor Management**: Complete donor registration and profile management
- **Charity Management**: Charity registration and profile management
- **Campaign Management**: Create and manage fundraising campaigns
- **Fundraiser Campaign Management**: Specialized campaigns with fundraising goals
- **Transaction Processing**: Handle donation transactions with receipt generation
- **Recurring Donations**: Support for automated recurring donation schedules
- **Payment Methods**: Multiple payment options (Card, Net Banking, UPI, Wallet)
- **Contact Preferences**: Manage donor communication preferences

### Advanced Features

- **Donation Summaries**: Track donor and campaign donation statistics
- **Receipt Management**: Automated receipt generation and tracking
- **Campaign Analytics**: Real-time campaign performance tracking

## 🏗️ Architecture

The project follows a layered architecture pattern with clear separation of concerns:

```
Charity_Donation_Platform/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/charityapp/
│   │   │       ├── Main.java                 # Application entry point
│   │   │       ├── dao/                      # Data Access Objects
│   │   │       ├── db/                       # Database utilities
│   │   │       ├── dto/                      # Data Transfer Objects
│   │   │       ├── enums/                    # Enumeration types
│   │   │       ├── mapper/                   # Object mappers
│   │   │       ├── model/                    # Entity models
│   │   │       └── service/                  # Business logic services
│   │   └── resources/                        # Configuration files
│   │       ├── db.properties                 # Database configuration (not committed)
│   │       └── schema.sql                    # Database schema
│   └── test/                                 # Service layer tests
└── README.md                                 # Project documentation
```

### Technology Stack

- **Language**: Java 8+
- **Build Tool**: Gradle
- **Database**: MySQL
- **Testing**: JUnit 5
- **IDE Support**: IntelliJ IDEA
- **Architecture**: Layered Architecture (DAO, Service, DTO pattern)
- **Package Structure**: Standard Maven/Gradle directory layout

## 📋 Prerequisites

Before running this application, ensure you have the following installed:

- **Java JDK 8 or higher**
- **MySQL Server 5.7 or higher**
- **Gradle 7.0 or higher**

## 🚀 Installation & Setup

### 1. Clone the Repository

```bash
git clone <repository-url>
cd Charity_Donation_Platform
```

### 2. Database Setup

1. Create a MySQL database:

```sql
CREATE DATABASE charitydb;
```

2. Create the database configuration file `src/main/resources/db.properties`:

```properties
db.url=jdbc:mysql://your-database-host:3306/charitydb
db.username=your_username
db.password=your_password
```

### 3. Run the Application


## 🗄️ Database Schema

The application uses the following main entities:

### Core Entities

- **Donor**: Stores donor information and preferences
- **Charity**: Manages charity profiles and details
- **Campaign**: Regular donation campaigns
- **FundraiserCampaign**: Specialized fundraising campaigns with goals
- **CampaignTransaction**: Records of campaign donations
- **FundraiserTransaction**: Records of fundraiser donations

### Supporting Entities

- **RecurringDonation**: Manages automated recurring donations
- **PaymentMethod**: Stores donor payment information
- **ContactPreference**: Manages donor communication preferences
- **DonorDonationSummary**: Aggregated donor donation statistics
- **FundraiserSummary**: Campaign fundraising progress tracking

## 🧪 Testing

The project includes comprehensive unit tests for all services:

```bash

### Test Coverage

- **Service Layer Tests**: All business logic services


## 🔧 Configuration

### Database Configuration

The application uses `src/main/resources/db.properties` for database connection settings:

```properties
db.url=jdbc:mysql://your-database-host:3306/charityDb
db.username=your_username
db.password=your_password
```

### Environment Variables

- `DB_URL`: Database connection URL
- `DB_USERNAME`: Database username
- `DB_PASSWORD`: Database password



**Note**: This is a backend application. For a complete donation platform, consider integrating with a frontend application or REST API layer.

