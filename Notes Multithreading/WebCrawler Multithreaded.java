class Solution {
    String hostName; // The hostname extracted from the starting URL
    private ConcurrentHashMap<String, Boolean> visitedUrls;
    HtmlParser htmlParser; 
    ExecutorService executorService; 

    Solution() {
        visitedUrls = new ConcurrentHashMap<>();
    }

    class CrawlTask implements Runnable{
        String url; // URL to crawl

        CrawlTask(String url) {
            this.url = url;
        }

        @Override
        public void run() {

            // Get all URLs from the current page
            List<String> adjacentUrls = htmlParser.getUrls(url);


            for (String adjUrl : adjacentUrls) {
                // If the URL has not been visited and has same hostname, add it to the task queue
                if (getHostName(adjUrl).equals(hostName) && visitedUrls.putIfAbsent(adjUrl, true) == null) {
                    executorService.submit(new CrawlTask(adjUrl));
                }
            }
            
        }
    }

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        this.htmlParser = htmlParser;
        hostName = getHostName(startUrl);

        // Initialize the executor service with a fixed thread pool
        executorService = Executors.newFixedThreadPool(5);
        try {
            visitedUrls.put(startUrl, true);
            // Submit the initial task
            executorService.submit(new CrawlTask(startUrl));
            // Wait for the tasks to complete
            executorService.awaitTermination(100, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }

        // Return the list of visited URLs
        return new ArrayList<>(visitedUrls.keySet());
    }

    public String getHostName(String url){
        return url.split("/")[2];
    }
}