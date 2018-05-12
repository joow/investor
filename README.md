# Investor

> Investor is a simple tool to help you allocate an investment regarding investment type targets.

## Usage

    ./gradlew run -Pfile=input.json
    
The input file is a JSON file with the following format :

    {
      // list of all accounts
      "accounts": [
        "name": "Name of the account",
        // list of all currently held positions
        "positions": [
          {
            "name": "Name of the position",
            "isin": "ISIN of the position (optional)",
            "type": "Type of the position",
            "shares": "Number of shares held",
            "price": "Current price of the position",
            "buy": indicate whether to buy or not the position. Optional (true by default)      
          }
        ],
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
