# BeyiPIS

[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](./LICENSE)  
[![Build Status](https://img.shields.io/github/actions/workflow/status/owamani44/BeyiPIS/ci.yml?branch=main)](https://github.com/owamani44/BeyiPIS/actions)  
[![Version](https://img.shields.io/github/v/release/owamani44/BeyiPIS)](https://github.com/owamani44/BeyiPIS/releases)

> **Real-time Price Information System for Uganda Markets** — a platform providing timely price updates across all regions of Uganda to support **market transparency** and empower stakeholders with actionable pricing data.

## 🚀 What the Project Does

**BeyiPIS** is a full-stack, microservices-based platform designed to collect, process, and serve **real-time commodity price data** across Uganda’s regions. It enables:

- **Data ingestion** from market agents or external price sources
- **Real-time processing and analytics**
- **API access for frontend and third-party clients**
- **Notifications and alerts when prices change**
- **Regional price dashboards for transparency**

This system helps farmers, traders, policymakers, and apps make better decisions with up-to-date pricing data.


## 💡 Why This Project Matters

BeyiPIS addresses a common challenge in agricultural and commodity markets:

- 📊 **Regional price transparency** — eliminates information asymmetry
- 📈 **Market insights** — analyze price trends across regions
- 📱 **Real-time updates** — users get notifications as prices change
- ⚙️ **Extensible microservices** — easy to extend with new data sources



## 🛠️ Getting Started

### Requirements

Make sure you have installed:

- **Docker** & **Docker Compose**
- **Node.js** (v16+)
- **Java JDK** (for backend services)
- **MongoDB / PostgreSQL** (optional if running via compose)



### Set Up Locally (Dev)

1. **Clone the repository**
   ```sh
   git clone https://github.com/owamani44/BeyiPIS.git
   cd BeyiPIS

