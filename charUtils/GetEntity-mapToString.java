 /**
     * 将类中具体field，转换成相应的map集合，但是需要注意的是，有些字段不是必须的；
     * int 默认时为0，0在字段中可以有意思的存在的;所以这里使用相应的封装类，封装类可以指定null,或者相应的基础类
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
            c = Class.forName(thisObj.getClass().getName()); // 获取object的class对象
            Method[] m = c.getMethods();
            for (int i = 0; i < m.length; i++)
            {
                String method = m[i].getName();// 遍历所有的方法，其getName后面即为相应的变量名字
                if (method.startsWith("get"))
                {
                    try
                    {
                        Object value = m[i].invoke(thisObj);
                        if (value != null && !"getClass".equals(method)) //value为空，则不存放
                        {
                            String key = method.substring(3); // 3即为get的长度
                            key = key.substring(0, 1).toUpperCase() + key.substring(1);// 大小写的变化
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
     * 将map集合的字符对转换成字符串,字符串的格式是 a=43&b=23&c=10
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
            if (!(o instanceof String)) // 不是String,转换成String
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