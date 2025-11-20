**1**
curl -v http://localhost:8080/clients | python3 -m json.tool

**2**
curl -X POST http://localhost:8080/transactions/transfer \
     -H "Content-Type: application/json" \
     -d '{"fromAccountNumber": "C1", "toAccountNumber": "E1", "amount": 100.0}'

**3**
curl -s http://localhost:8080/clients | python3 -m json.tool

**4**
curl -X POST http://localhost:8080/transactions/transfer \
     -H "Content-Type: application/json" \
     -d '{"fromAccountNumber": "C1", "toAccountNumber": "E1", "amount": 5000.0}' -v
