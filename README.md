# Payment API

Welcome to the Payment API repository for our startup in the payment industry. This API allows users to make payments and retrieve payment information. The API is designed to support multiple payment types and various devices.

## Overview

As of now, the Payment API supports card payments, but it is designed to easily accommodate additional payment types in the future. The API is optimized for both mobile and browser usage.

## Getting Started

### Prerequisites

To run this project, you need to have the following installed:

- Java (JDK 8 or higher)
- Maven
- H2 Database (optional, as H2 is embedded)

### Installation

1. **Clone the repository:**

    ```bash
    git clone https://github.com/Thinkit-lab/Payment-API
    ```

2. **Build the project:**

    ```bash
    cd payment-api
    mvn clean install
    ```

3. **Run the application:**

    ```bash
    mvn spring-boot:run
    ```

    The application will be accessible at `http://localhost:2023`.

## Usage

### Make Payment

Endpoint: `POST /api/v1/payment/process_payment`

Make a payment by providing the necessary details in the request body.

### Get Payments

Endpoint: `GET /api/v1/payment/get_payment/1?pageNumber=1&pageSize=3`

Retrieve a list of payments.

## Supported Payment Types

As of now, the Payment API supports card payments. Future updates will include additional payment types.

## Device Compatibility

The API is designed to work seamlessly on both mobile devices and browsers. The endpoints are responsive and provide a consistent experience across platforms.

## Database

The application uses an H2 database for data storage. You can access the H2 console at `http://localhost:8080/h2-console` (credentials: username - sa, password - password).

## Swagger Documentation

Explore the API endpoints and test them interactively using Swagger documentation, available at `http://localhost:2023/swagger-ui/index.html#/`.

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, feel free to open an issue or create a pull request.

## License

This project is licensed under the [MIT License](LICENSE).
