package com.hyojin.Aladdin.service;

import com.hyojin.Aladdin.domain.Book;
import com.hyojin.Aladdin.dto.BookDTO;
import com.hyojin.Aladdin.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

@Service
@RequiredArgsConstructor
public class BookService {
    public static TreeSet<String> isbn13List= new TreeSet<>();

    private final BookRepository bookRepository;
    private final RestTemplate restTemplate; // RestTemplate 주입
    @Autowired
    public BookService(RestTemplate restTemplate, BookRepository bookRepository) {
        this.restTemplate = restTemplate;
        this.bookRepository = bookRepository;
    }

    @Transactional
    public void fetchDataFromApi() {

        //주간 베스트셀러 변경 코드


        //겹치는 id값 제외 코드
        //db에서 id를 전부 가져와서 for문으로 전부 비교
        //만약 같은 id가 있는 경우 id 제거
        //남은 id test 리스트에 담기
        List<String> itemList = new ArrayList<>();
        String itemListUrl = "http://www.aladin.co.kr/ttb/api/ItemList.aspx?ttbkey=ttbkoj8581120001&QueryType=ItemNewAll&MaxResults=100&start=1&SearchTarget=Book&output=JS&Version=20131101";
        String itemListUrl1 ="http://www.aladin.co.kr/ttb/api/ItemList.aspx?ttbkey=ttbkoj8581120001&QueryType=ItemNewAll&MaxResults=100&start=50&SearchTarget=Book&output=JS&Version=20131101";
        String itemListUrl2 ="http://www.aladin.co.kr/ttb/api/ItemList.aspx?ttbkey=ttbkoj8581120001&QueryType=ItemNewAll&MaxResults=100&start=100&SearchTarget=Book&output=JS&Version=20131101";
        String itemListUrl3 ="http://www.aladin.co.kr/ttb/api/ItemList.aspx?ttbkey=ttbkoj8581120001&QueryType=ItemNewAll&MaxResults=100&start=150&SearchTarget=Book&output=JS&Version=20131101";

        String itemListUrl4 = "http://www.aladin.co.kr/ttb/api/ItemList.aspx?ttbkey=ttbkoj8581120001&QueryType=ItemNewSpecial&MaxResults=100&start=1&SearchTarget=Book&output=JS&Version=20131101";
        String itemListUrl5 ="http://www.aladin.co.kr/ttb/api/ItemList.aspx?ttbkey=ttbkoj8581120001&QueryType=ItemNewSpecial&MaxResults=100&start=50&SearchTarget=Book&output=JS&Version=20131101";
        String itemListUrl6 = "http://www.aladin.co.kr/ttb/api/ItemList.aspx?ttbkey=ttbkoj8581120001&QueryType=ItemNewSpecial&MaxResults=100&start=100&SearchTarget=Book&output=JS&Version=20131101";
        String itemListUrl7 = "http://www.aladin.co.kr/ttb/api/ItemList.aspx?ttbkey=ttbkoj8581120001&QueryType=ItemNewSpecial&MaxResults=100&start=150&SearchTarget=Book&output=JS&Version=20131101";

        String itemListUrl8 = "http://www.aladin.co.kr/ttb/api/ItemList.aspx?ttbkey=ttbkoj8581120001&QueryType=Bestseller&MaxResults=100&start=1&SearchTarget=Book&output=JS&Version=20131101";
        String itemListUrl9 = "http://www.aladin.co.kr/ttb/api/ItemList.aspx?ttbkey=ttbkoj8581120001&QueryType=Bestseller&MaxResults=100&start=50&SearchTarget=Book&output=JS&Version=20131101";
        String itemListUrl10 = "http://www.aladin.co.kr/ttb/api/ItemList.aspx?ttbkey=ttbkoj8581120001&QueryType=Bestseller&MaxResults=100&start=100&SearchTarget=Book&output=JS&Version=20131101";
        String itemListUrl11 ="http://www.aladin.co.kr/ttb/api/ItemList.aspx?ttbkey=ttbkoj8581120001&QueryType=Bestseller&MaxResults=100&start=150&SearchTarget=Book&output=JS&Version=20131101";

        String itemListUrl12 = "http://www.aladin.co.kr/ttb/api/ItemList.aspx?ttbkey=ttbkoj8581120001&QueryType=BlogBest&MaxResults=100&start=1&SearchTarget=Book&output=JS&Version=20131101";
        String itemListUrl13 = "http://www.aladin.co.kr/ttb/api/ItemList.aspx?ttbkey=ttbkoj8581120001&QueryType=BlogBest&MaxResults=100&start=50&SearchTarget=Book&output=JS&Version=20131101";
        String itemListUrl14 = "http://www.aladin.co.kr/ttb/api/ItemList.aspx?ttbkey=ttbkoj8581120001&QueryType=BlogBest&MaxResults=100&start=100&SearchTarget=Book&output=JS&Version=20131101";
        String itemListUrl15 ="http://www.aladin.co.kr/ttb/api/ItemList.aspx?ttbkey=ttbkoj8581120001&QueryType=BlogBest&MaxResults=100&start=150&SearchTarget=Book&output=JS&Version=20131101";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        itemList.add(restTemplate.getForObject(itemListUrl, String.class));
        itemList.add(restTemplate.getForObject(itemListUrl1, String.class));
        itemList.add(restTemplate.getForObject(itemListUrl2, String.class));
        itemList.add(restTemplate.getForObject(itemListUrl3, String.class));
        itemList.add(restTemplate.getForObject(itemListUrl4, String.class));
        itemList.add(restTemplate.getForObject(itemListUrl5, String.class));
        itemList.add(restTemplate.getForObject(itemListUrl6, String.class));
        itemList.add(restTemplate.getForObject(itemListUrl7, String.class));
        itemList.add(restTemplate.getForObject(itemListUrl8, String.class));
        itemList.add(restTemplate.getForObject(itemListUrl9, String.class));
        itemList.add(restTemplate.getForObject(itemListUrl10, String.class));
        itemList.add(restTemplate.getForObject(itemListUrl11, String.class));
        itemList.add(restTemplate.getForObject(itemListUrl12, String.class));
        itemList.add(restTemplate.getForObject(itemListUrl13, String.class));
        itemList.add(restTemplate.getForObject(itemListUrl14, String.class));
        itemList.add(restTemplate.getForObject(itemListUrl15, String.class));
        //System.out.println("apiUrl = " + itemList);

        for (int i = 0; i < itemList.size(); i++) {
            isbn13List=extractIsbn13FromJsonString(itemList.get(i));
        }
        isbn13List.remove(""); //널은 아닌데 없는값이자꾸 들어오는데 이유를 모르겠다. 일단 삭제
        int num=0;
        for (String isbn13 : isbn13List) {
            System.out.println(num+" ISBN13: " + isbn13);
            num++;
        }

        List<String> test = List.of("334786620", "335335761", "333419849", "334929927");

        List<Book> bookList = new ArrayList<>();
        for (String code : isbn13List) {
            String apiUrl = "https://www.aladin.co.kr/ttb/api/ItemLookUp.aspx?ttbkey=ttbkoj8581120001&itemIdType=ISBN13&ItemId=" + code + "&output=js&Version=20131101&OptResult=packing";

            try {
                BookDTO response = restTemplate.getForObject(apiUrl, BookDTO.class);

                BookDTO.Item item = response.getItem().get(0); //"국내도서>인문학>교양 인문학" 이런 형식 첫번째>뒤에있는 문자만 파싱
                String[] ParsingCategory = item.getCategoryName().split(">");

                    Book book = Book.builder()
                            .title(item.getTitle())
                            .author(item.getAuthor())
                            .publisher(item.getPublisher())
                            .pubDate(item.getPubDate())
                            .priceStandard(item.getPriceStandard())
                            .isbn13(item.getIsbn13())
                            .categoryName(ParsingCategory[1].trim())
                            .cover(item.getCover())
                            .link(item.getLink())
                            .itemPage(item.getSubInfo().getItemPage())
                            .description(item.getDescription())
                            .originalTitle(item.getSubInfo().getOriginalTitle())
                            .build();
                    bookList.add(book);



            } catch (RestClientException e) {
                System.err.println("API 요청 중 오류 발생: " + e.getMessage());
                // 필요한 경우, 로그 파일에 기록하거나, 다른 예외 처리 로직을 추가할 수 있습니다.
            }
        }
        bookRepository.saveAll(bookList);
    }


    private static TreeSet<String> extractIsbn13FromJsonString(String jsonString) {


        // JSON 문자열을 파싱하여 필요한 데이터 추출
        try {
            JSONParser parser = new JSONParser();
            JSONObject object = (JSONObject) parser.parse(jsonString);
            JSONArray itemArr = (JSONArray) object.get("item");
            for (Object item : itemArr) {
                JSONObject itemObj = (JSONObject) item;
                String isbn13 = (String) itemObj.get("isbn13");
                if(isbn13 != null) { // isbn13이 null이 아닌 경우에만 추가
                    isbn13List.add(isbn13);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isbn13List;
    }
}
