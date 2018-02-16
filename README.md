# Investor

> Investor is a simple tool to help you allocate an investment regarding investment type targets.

## Usage

    ./gradlew run -Pfile=input.json
    
The input file is a JSON file with the following format :

    {
      // list of all currently held positions
      "positions": [
        {
          "name": "Name of the position (fund)",
          "isin": "ISIN of the position (fund). Optional",
          "type": "Type of the position",
          "shares": number of shares held,
          "price": "Current price of the position (fund)",
          "buy": indicate whether to buy or not the position. Optional (true by default)      
        }
      ],
      // list of percentages for all allocated types
      "allocations": [
        {
          "type": "Type of the allocation. Corresponds to the type of the positions",
          "target": "Number between 0 and 100 indicating the percentage wanted for this type of allocation"
        }
      ],
      "investment": "Amount to invest"
    }

The output will state all positions to buy. 

## License

SEE [LICENSE](LICENSE)
