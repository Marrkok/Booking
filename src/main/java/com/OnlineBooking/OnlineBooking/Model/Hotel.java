package com.OnlineBooking.OnlineBooking.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

@Component
public class Hotel
{
    public static ArrayList<Hotel> hotels=new ArrayList<>();

    private int hotelID;
    private String hotelName;
    private String hotelAddress;
    private String RoomType;
    private int TotalRooms;
    private int AvailableRooms;
    private int Price;
    private String BookingID="H";

    public Hotel(){};

    public Hotel(int hotelID, String hotelName, String hotelAddress, String RoomType, int TotalRooms, int Price)
    {
        this.hotelID = hotelID;
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
        this.RoomType = RoomType;
        this.TotalRooms = TotalRooms;
        this.AvailableRooms = TotalRooms;
        this.Price = Price;
    }

    public int getHotelID()
    {
        return hotelID;
    }

    public void setHotelID(int hotelID)
    {
        this.hotelID = hotelID;
    }

    public String getHotelName()
    {
        return hotelName;
    }

    public void setHotelName(String hotelName)
    {
        this.hotelName = hotelName;
    }

    public String getRoomType()
    {
        return RoomType;
    }

    public void setRoomType(String roomType)
    {
        RoomType = roomType;
    }

    public String getHotelAddress()
    {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress)
    {
        this.hotelAddress = hotelAddress;
    }

    public int getAvailableRooms()
    {
        return AvailableRooms;
    }

    public void setAvailableRooms(int availableRooms)
    {
        AvailableRooms = availableRooms;
    }

    public int getPrice()
    {
        return Price;
    }

    public void setPrice(int price)
    {
        Price = price;
    }

    public int getTotalRooms()
    {
        return TotalRooms;
    }

    public void setTotalRooms(int totalRooms)
    {
        TotalRooms = totalRooms;
    }

    public void addHotel(Hotel h)
    {
        hotels.add(h);
    }

    public static Hotel FindByHotelName(String HotelName)
    {
        for(Hotel h : hotels)
        {
            if(h.getHotelName().equals(HotelName))
            {
                return h;
            }
        }

        return null;
    }
    public static void Fetch() {
        String url = "https://6765c5a6410f849996561d54.mockapi.io/api/v1/Hotels";
        RestTemplate restTemplate = new RestTemplate();
        // Use ParameterizedTypeReference to tell RestTemplate the type of the list
        ResponseEntity<List<Hotel>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Hotel>>() {}
        );

        List<Hotel> hotelsList = response.getBody();

        if (hotels != null) {
            hotels.addAll(hotelsList);
        }
    }

}
