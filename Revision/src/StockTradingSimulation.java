import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

class Stock {
    private String symbol;
    private String companyName;
    private double price;

    public Stock(String symbol, String companyName, double price) {
        this.symbol = symbol;
        this.companyName = companyName;
        this.price = price;
    }

    public synchronized void updatePrice(double newPrice) {
        this.price = newPrice;
    }

    public synchronized double getPrice() {
        return price;
    }

    public String getSymbol() {
        return symbol;
    }

    public void logTransaction(String logFileName, String transactionDetails) {
        synchronized (Stock.class) { // Synchronize logging to avoid race conditions
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFileName, true))) {
                writer.write(transactionDetails);
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class Trader implements Runnable {
    private String name;
    private StockMarket stockMarket;
    private String logFileName;

    public Trader(String name, StockMarket stockMarket, String logFileName) {
        this.name = name;
        this.stockMarket = stockMarket;
        this.logFileName = logFileName;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] stockSymbols = stockMarket.getStockSymbols();

        for (int i = 0; i < 10; i++) { // Simulate 10 transactions
            try {
                Thread.sleep(random.nextInt(1000)); // Random delay for simulation
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            String stockSymbol = stockSymbols[random.nextInt(stockSymbols.length)];
            boolean isBuying = random.nextBoolean();
            double transactionPrice = stockMarket.getStockPrice(stockSymbol);

            if (isBuying) {
                stockMarket.buyStock(name, stockSymbol, transactionPrice, logFileName);
            } else {
                stockMarket.sellStock(name, stockSymbol, transactionPrice, logFileName);
            }
        }
    }
}

class StockMarket {
    private HashMap<String, Stock> stocks = new HashMap<>();

    public synchronized void addStock(Stock stock) {
        stocks.put(stock.getSymbol(), stock);
    }

    public synchronized String[] getStockSymbols() {
        return stocks.keySet().toArray(new String[0]);
    }

    public synchronized double getStockPrice(String symbol) {
        return stocks.get(symbol).getPrice();
    }

    public void buyStock(String traderName, String stockSymbol, double price, String logFileName) {
        Stock stock = stocks.get(stockSymbol);
        synchronized (stock) { // Synchronize on the specific stock
            stock.updatePrice(price + (Math.random() * 5)); // Simulate price increase after buying
            String transactionDetails = String.format(
                    "[%s] %s bought %s at $%.2f",
                    getCurrentTime(), traderName, stockSymbol, stock.getPrice()
            );
            stock.logTransaction(logFileName, transactionDetails);
        }
    }

    public void sellStock(String traderName, String stockSymbol, double price, String logFileName) {
        Stock stock = stocks.get(stockSymbol);
        synchronized (stock) { // Synchronize on the specific stock
            stock.updatePrice(price - (Math.random() * 5)); // Simulate price decrease after selling
            String transactionDetails = String.format(
                    "[%s] %s sold %s at $%.2f",
                    getCurrentTime(), traderName, stockSymbol, stock.getPrice()
            );
            stock.logTransaction(logFileName, transactionDetails);
        }
    }

    private String getCurrentTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}

public class StockTradingSimulation {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();
        stockMarket.addStock(new Stock("AAPL", "Apple Inc.", 150.00));
        stockMarket.addStock(new Stock("GOOGL", "Alphabet Inc.", 2800.00));
        stockMarket.addStock(new Stock("AMZN", "Amazon.com Inc.", 3500.00));
        stockMarket.addStock(new Stock("MSFT", "Microsoft Corp.", 310.00));
        stockMarket.addStock(new Stock("TSLA", "Tesla Inc.", 700.00));

        String logFileName = "stock_transactions.log";

        Thread trader1 = new Thread(new Trader("Trader1", stockMarket, logFileName));
        Thread trader2 = new Thread(new Trader("Trader2", stockMarket, logFileName));
        Thread trader3 = new Thread(new Trader("Trader3", stockMarket, logFileName));

        trader1.start();
        trader2.start();
        trader3.start();

        try {
            trader1.join();
            trader2.join();
            trader3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Stock trading simulation completed. Check the log file for details.");
    }
}
