## 📊 Post Performance Analyzer

This is a Spring Boot application for analyzing performance of Facebook page posts using Meta Graph API.
It was built with Java 21, Spring Boot and Chart.js for visualization.

### 🌐 Live Demo

https://performanceanalysis-production-1aa6.up.railway.app/

---
### ⚙️ Setup & Installation

Prerequisites  
- Java21
- Gradle

1. Clone repository  
_git clone https://github.com/Zara-Mzada/performance_analysis/tree/main_
_cd performance_analysis_


2. Set environment variable  
Create a .env file or set the following variables:
_META_ACCESS_TOKEN=your_meta_access_token_
_META_PAGE_ID=your_facebook_page_id_


3. Build the project  
_./gradlew clean build -x test_


4. Run the application  
_java -jar build/libs/app.jar_

In this case application will start on http://localhost:8081

---

### 🚀 Usage

<u>Web Interface</u>  
Open your browser and go to http://localhost:8081  
You will see:
- Average count of likes and comments
- Best performing day of week
- Top 3 posts by engagement
- Bar chart of likes by day of week

<u>API Endpoints</u>

- GET &emsp; -> &emsp; /api/meta/posts &emsp; -> &emsp; Returns last 20 posts
- GET &emsp; -> &emsp; /api/meta/analysis &emsp; -> &emsp; Returns full analysis

### 📊 Sample Analysis Results

Below is a sample output from the `/api/meta/analysis` endpoint:

**Summary**

| Metric | Value |
|--------|-------|
| Average Likes | 343.55 |
| Average Comments | 66.5 |
| Best Day | Tuesday |

**🏆 Top 3 Posts by Engagement**

| # | Post | Likes | Comments | Engagement |
|---|------|-------|----------|------------|
| 1 | Thank you for 1 million impressions this month! 🎉 | 721 | 167 | 888 |
| 2 | Just launched our new website! Check it out 🌐 | 634 | 112 | 746 |
| 3 | We are hiring! Join our amazing team 🎯 | 567 | 134 | 701 |

**📅 Likes by Day of Week**

| Day | Total Likes |
|-----|-------------|
| Tuesday | 1980 |
| Thursday | 1235 |
| Saturday | 1166 |
| Wednesday | 854 |
| Sunday | 644 |
| Monday | 622 |
| Friday | 370 |

### 🤓Analysis Explanation

Application analyze last 20 posts:

<u>Top 3 posts by engagement</u>  
It is calculated as:  
Engagement = Likes count + Comments count  
Posts are sorted by descending order and the top 3 posts are returned 

<u>Likes by day of week</u>  
Posts are grouped by the day they were published, then total likes
are summed up for finding the best performing day.

**Summary Statistics**
- Average likes - count across all 20 posts
- Average comments - count across all 20 posts
- Best Day - the day of the week with the highest total likes

### 🏗️ Architecture

performance_analysis/

├── src/main/java/com/performance_analyze/

│   ├── config/

│   │   └── CorsConfig.java       #  CORS configuration

│   ├── controller/

│   │   └── PostController.java       # REST endpoints

│   ├── service/

│   │   └── MetaApiService.java       # Business logic & Meta API calls

│   ├── utils/

│   │   └── UtilMethods.java          # Analysis methods

│   └── entity/

│       └── PostData.java             # Post data model

├── src/main/resources/

│   └── static/

│       ├── index.html                # Frontend UI

│       ├── index.js                  # Chart.js & API calls

│       └── style.css                 # Styling

├── Dockerfile

├── railway.toml

└── README.md


### 🗒️ Notes

- Currently, uses mock data for demonstration purposes. 
When a valid Meta access token is provided, the application fetches real 
data from the Meta Graph API.
- Mock data includes 20 sample posts with varied 
engagement metrics across different days of the week.



