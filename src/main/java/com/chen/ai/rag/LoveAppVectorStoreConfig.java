package com.chen.ai.rag;

import jakarta.annotation.Resource;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class LoveAppVectorStoreConfig {

    @Resource
    private LoveAppDocumentLoader loveAppDocumentLoader;

    @Resource
    private MyTokenTextSplitter myTokenTextSplitter;

    @Resource
    private MyKeywordEnricher myKeywordEnricher;

    @Bean
    VectorStore loveAppVectorStore(EmbeddingModel dashscopeEmbedding) {
        SimpleVectorStore simpleVectorStore = SimpleVectorStore.builder(dashscopeEmbedding)
                .build();
        // 加载文档
        List<Document> documents = loveAppDocumentLoader.loadMarkdowns();
        // 自主切分
//        List<Document> splitDocuments = myTokenTextSplitter.splitCustomized(documents);
        //增加元信息
        List<Document> documentList = myKeywordEnricher.enrichDocuments(documents);
        simpleVectorStore.add(documentList);
        return simpleVectorStore;
    }
}
