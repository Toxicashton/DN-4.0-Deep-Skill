BEGIN
    FOR customer_rec IN (SELECT CustomerID, Balance FROM Customers) LOOP
        IF customer_rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = customer_rec.CustomerID;
        END IF;
    END LOOP;
    COMMIT;
END;
/