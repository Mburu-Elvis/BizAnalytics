src/main/java/com/yourcompany/datainjector/
├── config/
│   ├── KafkaConfig.java          # Configuration for Kafka (Producer/Consumer setup)
│   ├── SchedulerConfig.java      # Optional: Configurations for batch jobs and scheduling
│   └── WebhookConfig.java        # Optional: Configurations for handling webhooks
│
├── controller/
│   ├── WebhookController.java    # Handles webhook API requests
│   ├── FileIngestionController.java # Handles file uploads
│   └── ApiIngestionController.java  # Handles API-based data fetching
│
├── dto/
│   ├── WebhookRequest.java       # DTO for webhook payload
│   ├── FileUploadRequest.java    # DTO for file upload payload
│   └── ApiFetchRequest.java      # DTO for API fetch configuration
│
├── exception/
│   ├── IngestionException.java   # Custom exceptions for ingestion errors
│   ├── FileProcessingException.java # Exception for file-related errors
│   └── ApiIngestionException.java  # Exception for API ingestion errors
│
├── service/
│   ├── KafkaProducerService.java # Service for producing messages to Kafka
│   ├── WebhookIngestionService.java # Logic for webhook ingestion
│   ├── FileIngestionService.java    # Logic for processing and ingesting files
│   └── ApiIngestionService.java     # Logic for fetching and processing data from APIs
│
├── processor/
│   ├── MessageProcessor.java     # Generic interface for processing messages
│   ├── WebhookProcessor.java     # Implementation of message processor for webhooks
│   ├── FileProcessor.java        # Implementation for file ingestion processing
│   └── ApiProcessor.java         # Implementation for API-based ingestion
│
├── repository/
│   ├── EventRepository.java      # Repository for storing processed events
│   ├── FileMetadataRepository.java # Repository for storing file metadata
│   └── ApiConfigRepository.java  # Repository for API fetch configurations
│
├── model/
│   ├── Event.java                # Model representing an ingested event
│   ├── FileMetadata.java         # Model representing metadata for ingested files
│   └── ApiFetchConfig.java       # Model for API fetch configurations
│
├── utils/
│   ├── ValidationUtils.java      # Utilities for validating payloads
│   ├── FileUtils.java            # Utilities for file handling
│   └── ApiUtils.java             # Utilities for API interactions
│
├── Application.java              # Main Spring Boot application entry point
└── resources/
├── application.yml           # Spring Boot application configuration
├── logback.xml               # Logging configuration
└── schema/                   # Directory for schema files (e.g., Avro or JSON schemas)
├── webhook-event.avsc    # Avro schema for webhook events
├── file-metadata.avsc    # Avro schema for file metadata
└── api-fetch-config.avsc # Avro schema for API configurations
