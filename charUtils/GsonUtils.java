public class CommonJson<T>
{

    /**
     * rcode : 200
     * msg : ��ȡToken�ɹ�
     * data : {"token":"05f9e0ba26254b529625da8c424cb089"}
     */
    private String rcode;
    private String msg;
    private T data; // ��������T�Ǳ仯��

    public String getRcode()
    {
        return rcode;
    }

    public void setRcode(String rcode)
    {
        this.rcode = rcode;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public T getData()
    {
        return data;
    }

    public void setData(T t)
    {
        this.data = t;
    }

	/**
		json����Ϊ���ʽ�����ַ���
		clazz����Ӧ����Ӧ�� T ��Ӧ������
	*/
    public static CommonJson fromJson(String json, Class clazz)
    {
        Gson gson = new Gson();
        Type objectType = type(CommonJson.class, clazz);
        return gson.fromJson(json, objectType);
    }
	
    public String toJson(Class<T> clazz)
    {
        Gson gson = new Gson();
        Type objectType = type(CommonJson.class, clazz);
        return gson.toJson(this, objectType);
    }

    static ParameterizedType type(final Class raw, final Type... args)
    {
        return new ParameterizedType()
        {
            public Type getRawType()
            {
                return raw;
            }

            public Type[] getActualTypeArguments()
            {
                return args;
            }

            public Type getOwnerType()
            {
                return null;
            }
        };
    }
}

public class CommonJsonList<T> implements Serializable
{
    private static final long serialVersionUID = -369558847578246550L;

    private String rcode;
    private String msg;
	
	
    /**
     * �������б�����ͣ���ʾ���Ǽ��ϣ�
     */
    private List<T> data;


    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public String getRcode()
    {
        return rcode;
    }

    public void setRcode(String rcode)
    {
        this.rcode = rcode;
    }


    public List<T> getData()
    {
        return data;
    }

    public void setData(List<T> data)
    {
        this.data = data;
    }

    public static CommonJsonList fromJson(String json, Class clazz)
    {
        Gson gson = new Gson();
        Type objectType = type(CommonJsonList.class, clazz);
        return gson.fromJson(json, objectType);
    }

    public String toJson(Class<T> clazz)
    {
        Gson gson = new Gson();
        Type objectType = type(CommonJsonList.class, clazz);
        return gson.toJson(this, objectType);
    }

    static ParameterizedType type(final Class raw, final Type... args)
    {
        return new ParameterizedType()
        {
            public Type getRawType()
            {
                return raw;
            }

            public Type[] getActualTypeArguments()
            {
                return args;
            }

            public Type getOwnerType()
            {
                return null;
            }
        };
    }
}
