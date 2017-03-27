 /**
     * �����о���field��ת������Ӧ��map���ϣ�������Ҫע����ǣ���Щ�ֶβ��Ǳ���ģ�
     * int Ĭ��ʱΪ0��0���ֶ��п�������˼�Ĵ��ڵ�;��������ʹ����Ӧ�ķ�װ�࣬��װ�����ָ��null,������Ӧ�Ļ�����
     *
     * @param thisObj
     * @return
     */
    public static Map getValue(Object thisObj)
    {
        Map map = new LinkedHashMap<>();
        Class c;
        try
        {
            c = Class.forName(thisObj.getClass().getName()); // ��ȡobject��class����
            Method[] m = c.getMethods();
            for (int i = 0; i < m.length; i++)
            {
                String method = m[i].getName();// �������еķ�������getName���漴Ϊ��Ӧ�ı�������
                if (method.startsWith("get"))
                {
                    try
                    {
                        Object value = m[i].invoke(thisObj);
                        if (value != null && !"getClass".equals(method)) //valueΪ�գ��򲻴��
                        {
                            String key = method.substring(3); // 3��Ϊget�ĳ���
                            key = key.substring(0, 1).toUpperCase() + key.substring(1);// ��Сд�ı仯
//                            map.put(method.substring(3).toLowerCase(), value);
                            map.put(key, value);
                        }
                    }
                    catch (Exception e)
                    {
                        System.out.println("error:" + method);
                    }
                }
            }
        }
        catch (Exception e)
        {
            // TODO: handle exception
        }
        return map;
    }
	
	/**
     * ��map���ϵ��ַ���ת�����ַ���,�ַ����ĸ�ʽ�� a=43&b=23&c=10
     *
     * @param srcMap
     * @return
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public String mapConvertString(Map<String, Object> srcMap)
    {
        StringBuffer stringBuffer = new StringBuffer();
        if (srcMap == null || srcMap.size() <= 0)
        {
            return null;
        }

        Set<String> strings = srcMap.keySet();

        int i = 0;
        for (String str : strings)
        {
            Object o = srcMap.get(str);
            String eachString;
            if (!(o instanceof String)) // ����String,ת����String
            {
                eachString = String.valueOf(o);
            }
            else
            {
                eachString = (String) o;
            }
            stringBuffer.append(str).append("=").append(eachString);
            if (i != strings.size() - 1)
            {
                stringBuffer.append("&");
            }
            i++;
        }

//        L.i("stringBuffer.toString():" + stringBuffer.toString());
        return stringBuffer.toString();//
    }